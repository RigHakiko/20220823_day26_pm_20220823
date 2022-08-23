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

//        //测add 成功, 注释掉之
//        Book book = new Book();
//        book.setName("斗破苍穹");
//        book.setAuthor("天蚕土豆");
//        book.setPrice(28.8);
//        result = bookMapper.addBook(book);
//        sqlSession.commit();
//        System.out.println(result);
//
//        //测update 成功, 注释掉之
//        Book book2 = new Book();
//        book2.setId(25);
//        book2.setName("25newName");
//        book2.setAuthor("25newAuthor");
//        book2.setPrice(25.0);
//        result = bookMapper.updateBook(book2);
//        sqlSession.commit();
//        System.out.println(result);
//
//        //测删除 成功, 注释掉之
//        Integer idToDelete = 28;
//        result = bookMapper.deleteBook(idToDelete);
//        System.out.println(result);
//
//        //全查询 成功, 注释掉之
//        List<Book> books = bookMapper.selectBook();
//        for (Book book1 :
//                books) {
//            System.out.println(book1);
//        }

//        //根据id查询, 成功
//        Integer idToSelect = 9;
//        Book book5 = bookMapper.selectById(idToSelect);
//        System.out.println(book5);
//
//
//        //根据书名模糊查询 成功
//        String likeName = "梦";
//        List<Book> books6 = bookMapper.selectByName(likeName);
//        for (Book book6_02 :
//                books6) {
//            System.out.println(book6_02);
//        }

        String author07 = "吴承恩";
        List<Book> books07 = bookMapper.selectByAuthor(author07);
        for (Book book07 :
                books07) {
            System.out.println(book07);
        }


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
