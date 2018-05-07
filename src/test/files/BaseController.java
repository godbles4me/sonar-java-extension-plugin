package com.df.common.sonar.extension.examination;

public abstract class BaseController {

    @RequestMapping()
    public Result<Void> findList(@RequestBody CreateParam createParam) {
        return Result.<Void>create();
    }
}
