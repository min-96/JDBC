package com.newlecture.web;

import java.util.List;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

public class Program {

	public static void main(String[] args) {

		MemberService service = new MemberService();
		List<Member> list = service.getList();

		for (Member m : list)
			System.out.printf("nickname : %s, name : %s\n", m.getNicname(), m.getName());
	}

}
