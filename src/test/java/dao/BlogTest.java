package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlogTest {
    @Test
    public void test_getBlogs() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        for (Blog blog : mapper.getBlogs()) {
            System.out.println(blog);
        }
        // Mybatis默认开启一级缓存，一级缓存的范围是SqlSession。
        //sqlSession.clearCache();
        sqlSession.close();
    }

    @Test
    public void test_getBlogsIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        //map.put("title","title1");
        map.put("author","author1");
        List<Blog> blogs = mapper.getBlogsIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test_getBlogsChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        //map.put("title","title1");
        //map.put("author","author1");
        List<Blog> blogs = mapper.getBlogsChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test_getBlogsWhere() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","title1");
        //map.put("author","author1");
        List<Blog> blogs = mapper.getBlogsWhere(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test_updateBlogSet() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","title1");
        map.put("id",1);
        //map.put("author","author1");
        int lines = mapper.updateBlogSet(map);
        sqlSession.close();
    }

    @Test
    public void test_updateBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
        List<Blog> blogs = mapper.getBlogsForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
