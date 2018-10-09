package me.himna.sb.member.dao;

import me.himna.sb.member.domain.MemberDomain;

public interface MemberDao {
	public MemberDomain getMember(String login_id) throws Exception;
	public int memberJoin(MemberDomain member)  throws Exception;
	public int getLoginId(String id) throws Exception; 
	public MemberDomain getMemberById(int member_id) throws Exception; 
}
