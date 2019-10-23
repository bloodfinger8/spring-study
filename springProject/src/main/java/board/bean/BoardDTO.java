package board.bean;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
public class BoardDTO {
	private int seq;
    private String id; 
    private String name;
    private String email; 
    private String subject;
    private String content; 
    private int ref; //원글의 seq그룹번호, 답글의 답글도 존재
    private int lev; //답글의 단계
    private int step; //글순서 원글은 0번으
    private int pseq; //원글번호 0 ,답글 1 
    private int reply; 
    private int hit; //조회수
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd")
	private Date logtime;
    //select * from board order by ref desc, step asc;
	
    
    
	
    
    
    
    
}
