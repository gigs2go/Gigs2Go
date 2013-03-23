package com.gigs2go.model.repos;

import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

public abstract class AbstractRepoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Transient
    private Logger log = Logger.getLogger( AbstractRepoTest.class );

    @BeforeTransaction
    public void setupData () throws Exception {
        if ( countRowsInTable( "users" ) == 0 ) {
            log.debug( "Executing SQL insert" );
            executeSqlScript( "classpath:data.sql", false );
        }
    }
}
