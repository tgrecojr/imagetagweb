package com.greco.imagetag.bus;

import com.greco.imagetag.model.ObjectKey;
import com.greco.imagetag.repo.ObjectKeyLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class ObjectKeyController {

    @Value("${aws.s3.bucket}")
    private String s3Bucket;

    @Autowired
    private ObjectKeyLabelRepository objectKeyLabelRepository;

    @RequestMapping(path ="objectkey",method=GET)
    public List<ObjectKey> getObjectKeysForLabel(@RequestParam(value="label") String label){
        return objectKeyLabelRepository.findObjectKeysForLabel(s3Bucket,label);
    }
}
