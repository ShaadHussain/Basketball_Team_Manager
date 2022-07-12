package com.shaadhussain.teammanager.service;

import com.shaadhussain.teammanager.exceptions.UserNotFoundException;
import com.shaadhussain.teammanager.model.Member;
import com.shaadhussain.teammanager.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    private final MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Member addMember(Member member) {
        member.setEmployeeCode(UUID.randomUUID().toString());

        return memberRepo.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepo.findAll();
    }

    public Member updateMember(Member member) {
        return memberRepo.save(member);
    }

    public void deleteMember(Long id) {
        memberRepo.deleteMemberById(id);
    }

    public Member findMemberById(Long id) {
        return memberRepo.findMemberById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));

    }

}
