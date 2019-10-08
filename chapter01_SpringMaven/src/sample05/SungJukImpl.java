package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private Scanner scan = new Scanner(System.in);
	
	public SungJukImpl() {
		System.out.println("이름 입력 : ");
		this.name = scan.next();
		System.out.println("국어 입력 : ");
		this.kor = scan.nextInt();
		System.out.println("영어 입력 : ");
		this.eng = scan.nextInt();
		System.out.println("수학 입력 : ");
		this.math = scan.nextInt();
	}
	
	
	@Override
	public void calc() {
		total = kor + eng + math;
		avg = total / 3.0;
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name +"\t"+ kor +"\t"+ eng +"\t"+ math +"\t"+ total +"\t"+ String.format("%,.3f", avg));
	}



}
