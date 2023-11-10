package com.example.demo.model;


//import org.hibernate.annotations.GenericGenerator;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.persistence.UniqueConstraint;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
//@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@Document(collection = "User")
public class UserEntity {

    //@GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Id
    private String id; // 유저에게 고유하게 부여되는 id.

    //@Column(nullable = false)
    @Indexed(unique = true)
    private String username; // 아이디로 사용할 유저네임. 이메일일 수도 그냥 문자열일 수도 있다.

    private String password; // 패스워드.

    private String role; // 유저의 롤.

    private String authProvider; // example : facebook
}
