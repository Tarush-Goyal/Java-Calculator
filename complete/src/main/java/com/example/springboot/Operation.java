package com.example.springboot;

import org.springframework.web.bind.annotation.RequestBody;

public interface Operation {
    public OperationData operation (@RequestBody OperationData od);
}
