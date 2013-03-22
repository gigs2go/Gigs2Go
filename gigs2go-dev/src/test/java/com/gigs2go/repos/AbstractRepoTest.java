package com.gigs2go.repos;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

public abstract class AbstractRepoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData () throws Exception {
        if ( countRowsInTable( "users" ) == 0 ) {
            executeSqlScript( "classpath:security.sql", false );
        }
    }
}
