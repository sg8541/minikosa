package com.kosa.mini.controller.admin;

import com.kosa.mini.service.admin.ExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminExController {

    @Autowired
    ExService exService;
}
