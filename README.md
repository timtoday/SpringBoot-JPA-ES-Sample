# SpringBoot-JPA-ES-Sample

    docker run -d --name es762 -p 9200:9200   -v /Users/wang12/Workspace/docker/esdata:/usr/share/elasticsearch/data -e "discovery.type=single-node" elasticsearch:7.6.2

docker限制es占用的cpu和mem
    --cpuset-cpus="1"
    docker run -d --cpuset-cpus=1 -v /home/es/data:/usr/share/elasticsearch/data -v /home/es/logs:/usr/share/elasticsearch/logs -p 9200:9200 --name='es' elasticsearch:7.6.2

    --memory="4G" / -m 4G
    docker run -d --cpuset-cpus="1" -m 2G -v /home/es/data:/usr/share/elasticsearch/data -v /home/es/logs:/usr/share/elasticsearch/logs -p 9200:9200 --name='es' elasticsearch:7.6.2


访问测试 http://localhost:9200


管理端
Chrome 插件 
ElasticSearch Head



关键字
使用示例
等同于的ES查询
And 

    findByNameAndPrice 
    {“bool” : {“must” : [ {“field” : {“name” : “?”}}, {“field” : {“price” : “?”}} ]}} 
    
Or 

    findByNameOrPrice 
    {“bool” : {“should” : [ {“field” : {“name” : “?”}}, {“field” : {“price” : “?”}} ]}} 
Is 

    findByName 
    {“bool” : {“must” : {“field” : {“name” : “?”}}}} 
Not 

    findByNameNot 
    {“bool” : {“must_not” : {“field” : {“name” : “?”}}}} 
Between 

    findByPriceBetween 
    {“bool” : {“must” : {“range” : {“price” : {“from” : ?,“to” : ?,“include_lower” : true,“include_upper” : true}}}}} 
LessThanEqual

    findByPriceLessThan 
    {“bool” : {“must” : {“range” : {“price” : {“from” : null,“to” : ?,“include_lower” : true,“include_upper” : true}}}}} 
GreaterThanEqual 

    findByPriceGreaterThan 
    {“bool” : {“must” : {“range” : {“price” : {“from” : ?,“to” : null,“include_lower” : true,“include_upper” : true}}}}} 
Before 

    findByPriceBefore 
    {“bool” : {“must” : {“range” : {“price” : {“from” : null,“to” : ?,“include_lower” : true,“include_upper” : true}}}}} 
After 

    findByPriceAfter 
    {“bool” : {“must” : {“range” : {“price” : {“from” : ?,“to” : null,“include_lower” : true,“include_upper” : true}}}}} 
Like 

    findByNameLike 
    {“bool” : {“must” : {“field” : {“name” : {“query” : “? *”,“analyze_wildcard” : true}}}}} 
StartingWith 

    findByNameStartingWith 
    {“bool” : {“must” : {“field” : {“name” : {“query” : “? *”,“analyze_wildcard” : true}}}}} 
EndingWith 

    findByNameEndingWith 
    {“bool” : {“must” : {“field” : {“name” : {“query” : “*?”,“analyze_wildcard” : true}}}}} 
    Contains/Containing 
    findByNameContaining 
    {“bool” : {“must” : {“field” : {“name” : {“query” : “?”,“analyze_wildcard” : true}}}}} 
In 

    findByNameIn(Collectionnames) 
    {“bool” : {“must” : {“bool” : {“should” : [ {“field” : {“name” : “?”}}, {“field” : {“name” : “?”}} ]}}}} 
NotIn 

    findByNameNotIn(Collectionnames) 
    {“bool” : {“must_not” : {“bool” : {“should” : {“field” : {“name” : “?”}}}}}} 
True 

    findByAvailableTrue 
    {“bool” : {“must” : {“field” : {“available” : true}}}} 
False 

    findByAvailableFalse 
    {“bool” : {“must” : {“field” : {“available” : false}}}} 
OrderBy 

    findByAvailableTrueOrderByNameDesc 
    {“sort” : [{ “name” : {“order” : “desc”} }],“bool” : {“must” : {“field” : {“available” : true}}}} 
