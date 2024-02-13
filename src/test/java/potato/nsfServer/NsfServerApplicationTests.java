package potato.nsfServer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import javax.xml.crypto.Data;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import potato.nsfServer.DataCenter.application.DataService;
import potato.nsfServer.DataCenter.dao.RootDomainRepository;
import potato.nsfServer.DataCenter.domain.RootDomain;
import potato.nsfServer.DataCenter.dto.ResponseData;
import potato.nsfServer.DataCenter.exception.NoMoreDataException;

@SpringBootTest
class NsfServerApplicationTests {

	@Mock
	private RootDomainRepository rootDomainRepository;

	@InjectMocks
	DataService dataService;


	@Test
	void testHasList(){
		boolean emptyList = dataService.hasList(0);
		boolean normalList = dataService.hasList(1);

		System.out.println(emptyList);
		assertFalse(emptyList);
		assertTrue(normalList);
	}

	@Test
	void testNoMoreDataException() {
		// 목 객체 설정: findAll 메서드가 빈 페이지를 반환하도록 설정
		when(rootDomainRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(Page.empty());

		// NoMoreDataException이 발생하는지 확인
		assertThrows(NoMoreDataException.class, () -> dataService.getListofPart());
	}

	@Test
	void testHasData() {
		// 목 객체 설정: findAll 메서드가 데이터를 포함하는 페이지를 반환하도록 설정
		when(rootDomainRepository.findAll(Mockito.any(PageRequest.class)))
				.thenReturn(new PageImpl<>(Arrays.asList(new RootDomain())));

		// 예외가 발생하지 않는지 확인
		assertDoesNotThrow(() -> dataService.getListofPart());
	}

}
