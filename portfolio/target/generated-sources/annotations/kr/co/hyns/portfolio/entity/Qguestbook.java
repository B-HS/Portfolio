package kr.co.hyns.portfolio.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qguestbook is a Querydsl query type for guestbook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qguestbook extends EntityPathBase<guestbook> {

    private static final long serialVersionUID = 1432589081L;

    public static final Qguestbook guestbook = new Qguestbook("guestbook");

    public final QDateEntity _super = new QDateEntity(this);

    public final StringPath context = createString("context");

    public final NumberPath<Long> gid = createNumber("gid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> moddate = _super.moddate;

    public final BooleanPath open = createBoolean("open");

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regdate = _super.regdate;

    public final StringPath username = createString("username");

    public Qguestbook(String variable) {
        super(guestbook.class, forVariable(variable));
    }

    public Qguestbook(Path<? extends guestbook> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qguestbook(PathMetadata metadata) {
        super(guestbook.class, metadata);
    }

}

