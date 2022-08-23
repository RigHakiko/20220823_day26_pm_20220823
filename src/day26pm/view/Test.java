package day26pm.view;

import day26pm.entity.Book;
import day26pm.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    // 测试的代码过于复杂(少学了spring)
    public static void main(String[] args) throws Exception {
        //加载配置文件
        String resource = "sqlMapConfig.xml";
        int result;
        SqlSession sqlSession = null;

        InputStream is = Resources.getResourceAsStream(resource);
        //根据配置文件创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = sqlSessionFactory.openSession();

        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        //测add
        Book book = new Book();
        book.setName("斗破苍穹");
        book.setAuthor("天蚕土豆");
        book.setPrice(28.8);
        result = bookMapper.addBook(book);
        sqlSession.commit();
        System.out.println(result);

        //测update
        Book book2 = new Book();
        book2.setId(25);
        book2.setName("25newName");
        book2.setAuthor("25newAuthor");
        book2.setPrice(25.0);
        result = bookMapper.updateBook(book2);
        sqlSession.commit();
        System.out.println(result);

        //测删除
        Integer idToDelete = 28;
        result = bookMapper.deleteBook(idToDelete);
        System.out.println(result);


//        Book book1 = bookMapper.selectById(19);
//        System.out.println(book1);
//
//        List<Book> books = bookMapper.selectByName("三");
//        for (Book book2 :
//                books ) {
//            System.out.println(book2);
//        }
//
//        List<Book> books1 = bookMapper.selectByAuthor("曹雪芹");
//        for (Book book2 :
//                books1) {
//            System.out.println(book2);
//        }

    }
}
