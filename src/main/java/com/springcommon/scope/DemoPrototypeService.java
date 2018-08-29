package com.springcommon.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//1
public class DemoPrototypeService {

}
