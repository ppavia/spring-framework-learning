package ppa.spring.springframework.dataaccess.model.mock;

public record SimplePersonRecord(Long id, String lastName, String firstName) {

    public SimplePersonRecord(Long id){
        this(id, null, null);
    }

    public SimplePersonRecord() {
        this(null);
    }

}
