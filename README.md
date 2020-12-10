### 需求
1、有一个基础模块，代码表管理，类似基础数据字典，填充的是系统中使用的各种枚举。代码表在用户登录后会一次性返回给前端使用。  
2、代码为树状结构，每个代码下面关联的代码项是分层级的，比如“居住地”这个代码，返回的是省市县组成的一棵树。  
3、业务名词： codeDefine 代码定义;codeItem 代码值。  

### 实现
对于这样的数据：
```
CREATE TABLE `code` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code_define` varchar(45) NOT NULL DEFAULT '' COMMENT '代码定义',
  `code_item` varchar(45) NOT NULL COMMENT '代码值',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父id',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除,0否1是.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO `code` VALUES (1,'habitation','居住地',0,0),(2,'guangxi','广西',1,0),(3,'nanning','南宁',2,0),(4,'guilin','桂林',2,0),(5,'xixiangtang','西乡瑭',3,0),(6,'xxstreet','某某街道',5,0),(7,'guangdong','广东',1,0);

```
返回的树如下：
```
{
    "code": "200",
    "message": "获取数据成功",
    "data": {
        "tree": [
            {
                "id": 1,
                "codeDefine": "habitation",
                "codeItem": "居住地",
                "parentId": 0,
                "isDel": 0,
                "childList": [
                    {
                        "id": 2,
                        "codeDefine": "guangxi",
                        "codeItem": "广西",
                        "parentId": 1,
                        "isDel": 0,
                        "childList": [
                            {
                                "id": 3,
                                "codeDefine": "nanning",
                                "codeItem": "南宁",
                                "parentId": 2,
                                "isDel": 0,
                                "childList": [
                                    {
                                        "id": 5,
                                        "codeDefine": "xixiangtang",
                                        "codeItem": "西乡瑭",
                                        "parentId": 3,
                                        "isDel": 0,
                                        "childList": [
                                            {
                                                "id": 6,
                                                "codeDefine": "xxstreet",
                                                "codeItem": "某某街道",
                                                "parentId": 5,
                                                "isDel": 0,
                                                "childList": []
                                            }
                                        ]
                                    }
                                ]
                            },
                            {
                                "id": 4,
                                "codeDefine": "guilin",
                                "codeItem": "桂林",
                                "parentId": 2,
                                "isDel": 0,
                                "childList": []
                            }
                        ]
                    },
                    {
                        "id": 7,
                        "codeDefine": "guangdong",
                        "codeItem": "广东",
                        "parentId": 1,
                        "isDel": 0,
                        "childList": []
                    }
                ]
            }
        ]
    },
    "success": true
}
```
