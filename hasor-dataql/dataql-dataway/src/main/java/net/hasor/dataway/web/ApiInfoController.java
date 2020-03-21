package net.hasor.dataway.web;
import net.hasor.dataway.config.JsonRenderEngine;
import net.hasor.dataway.config.MappingToUrl;
import net.hasor.dataway.config.Result;
import net.hasor.web.Invoker;
import net.hasor.web.annotation.Get;
import net.hasor.web.annotation.QueryParameter;
import net.hasor.web.render.RenderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@MappingToUrl("/api/api-info")
@RenderType(engineType = JsonRenderEngine.class)
public class ApiInfoController {
    @Get
    public Result apiInfo(@QueryParameter("id") String apiId, Invoker invoker) {
        return Result.of(new HashMap<String, Object>() {{
            put("id", apiId);
            put("path", "/demos/db/databases/");
            put("status", 1);
            put("requestBody", "{'abc':true}");
            put("headerData", new ArrayList<Map<String, Object>>() {{
                add(newData(false, "key1", "value-1"));
                add(newData(true, "key2", "value-2"));
                add(newData(true, "key3", "value-3"));
                add(newData(false, "key4", "value-4"));
            }});
        }});
    }

    private HashMap<String, Object> newData(boolean checked, String key, String value) {
        return new HashMap<String, Object>() {{
            put("checked", checked);
            put("name", key);
            put("value", value);
        }};
    }
}
