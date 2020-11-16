package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;

public class MemberService {

	public List<Member> getList() {
		List<Member> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM MEMBER";
		String sql = "SELECT * FROM MEMBER WHERE PWD = '111'"; 
		// ��й�ȣ�� 111�� ��� ã�� >> Program���� ���ǹ����� ����ϴ� ���� �ƴϴ�!!
		// ���͸��� ���� ������ ���� ������ �������� ��� �ذ��ϵ��� �ؾ��Ѵ�.

		try {
			Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			String[] nicnames = new String[2];

//			if(rs.next()) {
//				nicnames[0] = rs.getNString("NICNAME");
//			}
//			
//			if(rs.next()) {
//				nicnames[1] = rs.getNString("NICNAME");
//			}

			while (rs.next()) { // ��ҹ��� �Ȱ���
				int id = rs.getInt("id");
				String nicname = rs.getString("nicname");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");

				Member m = new Member();
				m.setId(id);
				m.setNicname(nicname);
				m.setName(name);
				m.setPwd(pwd);

				list.add(m);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
