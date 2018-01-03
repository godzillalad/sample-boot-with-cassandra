package cass.repository.cassandra;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import cass.domain.HotelByLetter;
import cass.domain.HotelByLetterKey;
import cass.repository.HotelByLetterRepository;

@Repository
public class CassandraHotelByLetterRepository implements HotelByLetterRepository {
    private final CassandraTemplate cassandraTemplate;

    public CassandraHotelByLetterRepository(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public List<HotelByLetter> findByFirstLetter(String letter) {
        Select select = QueryBuilder.select().from("hotels_by_letter");
        select.where(QueryBuilder.eq("first_letter", letter));
        return this.cassandraTemplate.select(select, HotelByLetter.class);
    }

    @Override
    public HotelByLetter save(HotelByLetter hotelByLetter) {
        return this.cassandraTemplate.insert(hotelByLetter);
    }

    @Override
    public void delete(HotelByLetterKey hotelByLetterKey) {
        this.cassandraTemplate.deleteById(HotelByLetter.class, hotelByLetterKey);
    }
    
    @Override
    public void deleteAll() {
        this.cassandraTemplate.deleteAll(HotelByLetter.class);
    }

}
