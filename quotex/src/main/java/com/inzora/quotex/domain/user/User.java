package com.inzora.quotex.domain.user;

import com.inzora.quotex.application.dtos.requests.RegisterRequestDTO;
import com.inzora.quotex.domain.investment.Investment;
import com.inzora.quotex.enums.InvestmentProfile;
import com.inzora.quotex.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    @Enumerated(value = EnumType.STRING)
    private InvestmentProfile investment_profile;

    @Column(unique = true)
    private String email;

    private String password;

    private UserRole role;

    private Boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Investment> investments = List.of();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public User(RegisterRequestDTO data, String password){
        this.username = data.username();
        this.email = data.email();
        this.role = UserRole.USER;
        this.investment_profile = data.investmentProfile();
        this.password = password;
        this.enabled = true;
    }
}
