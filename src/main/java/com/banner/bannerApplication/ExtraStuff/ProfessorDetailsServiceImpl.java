package com.banner.bannerApplication.ExtraStuff;

//import com.banner.bannerApplication.entities.Position;
//import com.banner.bannerApplication.entities.Professor;
//import com.banner.bannerApplication.repositories.ProfessorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Service
//public class ProfessorDetailsServiceImpl implements UserDetailsService{
//    @Autowired
//    ProfessorRepository professorRepository;
//
//
//    @Transactional(readOnly = true)
//    public UserDetails loadbyUsername(String username) throws UsernameNotFoundException {
//        Professor professor= professorRepository.findByUsername(username);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Position position : professor.getPositions()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(position.getName()));
//        }
//        return new org.springframework.security.core.userdetails.User(professor.getUsername(),professor.getPassword(), grantedAuthorities);
//    }
//}
