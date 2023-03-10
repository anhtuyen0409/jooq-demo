/*
 * This file is generated by jOOQ.
 */
package com.nguyenanhtuyen.testjooq.tables;


import com.nguyenanhtuyen.testjooq.Keys;
import com.nguyenanhtuyen.testjooq.Testjooq;
import com.nguyenanhtuyen.testjooq.tables.records.ClassRecord;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Class extends TableImpl<ClassRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>testjooq.class</code>
     */
    public static final Class CLASS = new Class();

    /**
     * The class holding records for this type
     */
    @Override
    public java.lang.Class<ClassRecord> getRecordType() {
        return ClassRecord.class;
    }

    /**
     * The column <code>testjooq.class.id</code>.
     */
    public final TableField<ClassRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>testjooq.class.name</code>.
     */
    public final TableField<ClassRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    private Class(Name alias, Table<ClassRecord> aliased) {
        this(alias, aliased, null);
    }

    private Class(Name alias, Table<ClassRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>testjooq.class</code> table reference
     */
    public Class(String alias) {
        this(DSL.name(alias), CLASS);
    }

    /**
     * Create an aliased <code>testjooq.class</code> table reference
     */
    public Class(Name alias) {
        this(alias, CLASS);
    }

    /**
     * Create a <code>testjooq.class</code> table reference
     */
    public Class() {
        this(DSL.name("class"), null);
    }

    public <O extends Record> Class(Table<O> child, ForeignKey<O, ClassRecord> key) {
        super(child, key, CLASS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Testjooq.TESTJOOQ;
    }

    @Override
    public Identity<ClassRecord, Integer> getIdentity() {
        return (Identity<ClassRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ClassRecord> getPrimaryKey() {
        return Keys.KEY_CLASS_PRIMARY;
    }

    @Override
    public Class as(String alias) {
        return new Class(DSL.name(alias), this);
    }

    @Override
    public Class as(Name alias) {
        return new Class(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Class rename(String name) {
        return new Class(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Class rename(Name name) {
        return new Class(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
