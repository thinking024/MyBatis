package dao;

import pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    List<Blog> getBlogs();
    List<Blog> getBlogsIf(Map map);
    List<Blog> getBlogsChoose(Map map);
    List<Blog> getBlogsWhere(Map map);
    int updateBlogSet(Map map);
    List<Blog> getBlogsForeach(Map map);
}
