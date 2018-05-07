package com.df.common.sonar.extension.rules;

public abstract class AbstractService {

    public Result<Void> findList(@RequestBody CreateParam createParam) {
        return Result.<Void>create();
    }
}
