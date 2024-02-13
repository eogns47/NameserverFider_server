package potato.nsfServer.DataCenter.api;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import potato.nsfServer.DataCenter.application.DataService;
import potato.nsfServer.DataCenter.domain.RootDomain;
import potato.nsfServer.DataCenter.dto.ResponseData;
import potato.nsfServer.Global.common.response.ApiResponse;
import potato.nsfServer.Global.util.ApiUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataApi {
    private final RootDomain ip;


    @Autowired
    DataService dataService;

    @GetMapping("/listOfPart")
    public ApiResponse<ResponseData> distributePart() {
        ResponseData responseData = dataService.getListofPart();
        return ApiUtils.success(responseData);
    }

    @GetMapping("/dataCount")
    public ApiResponse<Long> countAll(){
        Long count = dataService.getCount();
        return ApiUtils.success(count);
    }

    @PostMapping("/setStartNum")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> init(@RequestBody int count){
        dataService.initCount(count);
        return ApiUtils.success("Set success");
    }

}

