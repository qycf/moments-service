package com.qu2u.moments.domain;


import com.qu2u.moments.entity.Images;
import lombok.Data;

import java.util.List;


@Data
public class ImagesGroup {

    private String creationDate;

    private List<Images> imagesList;

}
