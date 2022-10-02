package kr.co.hyns.portfolio.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDateEntity is a Querydsl query type for DateEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QDateEntity extends EntityPathBase<DateEntity> {

    private static final long serialVersionUID = 1035834873L;

    public static final QDateEntity dateEntity = new QDateEntity("dateEntity");

    public final DateTimePath<java.time.LocalDateTime> moddate = createDateTime("moddate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> regdate = createDateTime("regdate", java.time.LocalDateTime.class);

    public QDateEntity(String variable) {
        super(DateEntity.class, forVariable(variable));
    }

    public QDateEntity(Path<? extends DateEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateEntity(PathMetadata metadata) {
        super(DateEntity.class, metadata);
    }

}

