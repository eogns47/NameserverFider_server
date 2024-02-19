package potato.nsfServer.DataCenter.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import potato.nsfServer.DataCenter.dao.RootDomainRepository;
import potato.nsfServer.DataCenter.domain.RootDomain;
import potato.nsfServer.DataCenter.dto.ResponseData;
import potato.nsfServer.DataCenter.exception.NoMoreDataException;
import potato.nsfServer.Global.error.ErrorCode;

@Slf4j
@Service
public class DataService {

    @Autowired
    RootDomainRepository rootDomainRepository;

    private static int current_page = 0;
    private static final int size = 1000; // 페이지당 반환할 아이템 수


    public ResponseData getListofPart(){

        PageRequest pageRequest = PageRequest.of(current_page, size);
        int startData = current_page*size;
        current_page++;
        Page<RootDomain> pageResult = rootDomainRepository.findAll(pageRequest);

        if(hasList(pageResult.getSize())==false){
            log.warn(ErrorCode.DATA_IS_NOT_EXIST.getMessage());
            throw new NoMoreDataException();
        };

        int endData = (startData+pageResult.getSize()-1);
        log.info("Sent the data: "+startData+ " ~ " +endData);

        return ResponseData.of(pageResult.getContent(),startData,endData);
    }

    public long getCount(){
        return rootDomainRepository.count();
    }

    public long getRemainCount(){
        long remainCount = rootDomainRepository.count() - current_page * size;
        return remainCount;
    }

    public boolean hasList(int size) {
        return size > 0;
    }

    public void initCount(int count){
        current_page=count;
        log.info("Set StartNum as "+count);
    }

}
