package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Member;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Member addMember(Member member) {
        if (member.getBook() != null && member.getBook().getId() != null) {
            Book book = bookRepository.findById(member.getBook().getId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));
            member.setBook(book); // Set managed book entity
        }
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
