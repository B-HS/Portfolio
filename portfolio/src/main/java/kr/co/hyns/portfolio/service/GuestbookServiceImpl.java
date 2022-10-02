package kr.co.hyns.portfolio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

import kr.co.hyns.portfolio.dto.guestbookDTO;
import kr.co.hyns.portfolio.entity.Qguestbook;
import kr.co.hyns.portfolio.entity.guestbook;
import kr.co.hyns.portfolio.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{
    private final GuestbookRepository grepo;
    private final PasswordEncoder encoder;
    private final JPAQueryFactory queryFactory;
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public guestbookDTO writeGuestbook(guestbookDTO dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        guestbook result = DTOtoEntity(dto);
        grepo.save(result);
        return entityToDTO(result);
    }

    @Override
    public HashMap<String, Object> getGuestbookList(Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum-1, 2);
        Qguestbook qguestbook = Qguestbook.guestbook;
        List<guestbook> result = queryFactory
        .select(qguestbook)
        .from(qguestbook)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .orderBy(qguestbook.gid.desc())
        .fetch();
        

        List<guestbookDTO> dto = result.stream().map(new Function<guestbook,guestbookDTO>() {
            @Override
            public guestbookDTO apply(guestbook t) {
                return entityToDTO(t);
            }
        }).collect(Collectors.toList());

        Long count = queryFactory.select(qguestbook.count()).from(qguestbook).fetchOne();

        HashMap<String, Object> hash = new HashMap<>();
        hash.put("totalSize", count);
        hash.put("dtoList", dto);

        
        return hash;
    }
    
    @Override
    public Boolean modifyGuestbook(guestbookDTO dto) {
        Qguestbook qguestbook = Qguestbook.guestbook;
        JPAUpdateClause updateClause = new JPAUpdateClause(em, qguestbook);
        updateClause.where(qguestbook.gid.eq(dto.getGid())).set(qguestbook.context, dto.getContext()).execute();
        return true;
    }

    @Override
    public Boolean removeGuestbook(guestbookDTO dto) {
        log.info("-------------------------");
        log.info(dto);
        log.info("-------------------------");
        Qguestbook qguestbook = Qguestbook.guestbook;
        Optional<guestbook> result = Optional.ofNullable(queryFactory.select(qguestbook).from(qguestbook).where(qguestbook.gid.eq(dto.getGid())).fetchOne());
        if(result.isPresent() && encoder.matches(dto.getPassword(), result.get().getPassword())){
            grepo.delete(result.get());
            return true;
        }else{
            return false;
        }
    }
}
