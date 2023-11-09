package com.example.demo.dto;

import com.example.demo.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {  //todo item 생성, 수정ㅇ, 삭제. //계층 간 데이터 교환을 돕는다.
    //http 응답을 반환할 때, 비즈니스로직 캡슐화, 추가 정보 함꼐 반환 하기 위해 dto사용,
    //보안상 userId는 포함하지않는다.
    private String id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static TodoEntity toEntity(final TodoDTO dto) {  //dto를 entity로 변환
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
