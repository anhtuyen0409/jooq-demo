package com.nguyenanhtuyen.testjooq;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Main extends Tables{

	public static void main(String[] args) {
		String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/testjooq";

        try (Connection conn = (Connection) DriverManager.getConnection(url, userName, password)) {
        	DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        	
        	//select * from student
            Result<org.jooq.Record> result = create.select().from(STUDENT).fetch();
            System.out.println("Danh sách sv:");
            for (org.jooq.Record r : result) {
                Integer id = r.getValue(STUDENT.ID);
                String name = r.getValue(STUDENT.NAME);
                Integer age = r.getValue(STUDENT.AGE);
                String address = r.getValue(STUDENT.ADDRESS);

                System.out.println("ID: " + id + " name: " + name + " age: " + age + " address: " + address);
            }
            
            //select * from class
            System.out.println();
            System.out.println("Danh sách lớp:");
            Result<org.jooq.Record> classes = create.select().from(CLASS).fetch();
            for (org.jooq.Record r : classes) {
                Integer id = r.getValue(CLASS.ID);
                String name = r.getValue(CLASS.NAME);

                System.out.println("ID: " + id + " name: " + name);
            }
            
            //select count(*) from student
            System.out.println();
            Result<?> count = create.selectCount().from(STUDENT).fetch();
            System.out.println(count);
            
            //select distinct fisrt_name from student
            System.out.println();
            Result<?> distName = create.selectDistinct(STUDENT.NAME).from(STUDENT).fetch();
            for (org.jooq.Record r : distName) {
                String name = r.getValue(CLASS.NAME);

                System.out.println("Name: " + name);
            }
            
            //select * from student A
            //join class B on A.id_class = B.id;
            System.out.println();
            Result<org.jooq.Record> students = create.select().from(STUDENT)
            	    .join(CLASS).on(STUDENT.ID_CLASS.equal(CLASS.ID)).fetch();
            for (org.jooq.Record r : students) {
                Integer id = r.getValue(STUDENT.ID);
                String name = r.getValue(STUDENT.NAME);
                Integer age = r.getValue(STUDENT.AGE);
                String address = r.getValue(STUDENT.ADDRESS);

                System.out.println("ID: " + id + " name: " + name + " age: " + age + " address: " + address);
            }
            
            //select * from student A
            //group by id_class;
            System.out.println();
            Result<org.jooq.Record> result2 = create.select().from(STUDENT)
            	    .groupBy(STUDENT.ID_CLASS).fetch();
            for (org.jooq.Record r : result2) {
                Integer id = r.getValue(STUDENT.ID);
                String name = r.getValue(STUDENT.NAME);
                Integer age = r.getValue(STUDENT.AGE);
                String address = r.getValue(STUDENT.ADDRESS);

                System.out.println("ID: " + id + " name: " + name + " age: " + age + " address: " + address);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
