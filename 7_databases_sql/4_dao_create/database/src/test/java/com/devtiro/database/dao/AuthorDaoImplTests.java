package com.devtiro.database.dao;

import com.devtiro.database.dao.impl.AuthorDaoImpl;
import com.devtiro.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // 告诉 JUnit 5 使用 Mockito 的扩展，以便在测试时自动管理 mock 对象
public class AuthorDaoImplTests { // 测试类名，习惯上以 Tests 结尾

    @Mock
    private JdbcTemplate jdbcTemplate; // 假的

    @InjectMocks
    private AuthorDaoImpl underTest; // 把上面mock的jbdcTemplate注入，产生真正的AuthorDaoImpl实例，是 被测试对象的benchmark

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author author = Author.builder() // 创建一个Builder类的实例
                .id(1L)
                .name("Abigail Rose")
                .age(80) // Builder类定义的链式设置规则
                .build();

        underTest.create(author); // 根据create()方法的定义来完成被测试对象benchmark

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"), // 确认 SQL 语句是否正确
                eq(1L), eq("Abigail Rose"), eq(80) // 确认三个值是否是预期的值
        );
    }
}
