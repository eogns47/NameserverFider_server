package potato.nsfServer.DataCenter.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import potato.nsfServer.DataCenter.domain.RootDomain;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseData {
    private List<RootDomain> rootDomainList;
    private int startNumber;
    private int endNumber;


    public static ResponseData of(List<RootDomain> rootDomains, int startNumber, int endNumber) {
        return new ResponseData(rootDomains, startNumber, endNumber);
    }
}
