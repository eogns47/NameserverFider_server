package potato.nsfServer.DataCenter.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@Table(name = "tb_root_domain")
public class RootDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "root_id", nullable = false)
    private Long rootId;

    @Column(name = "root_domain", nullable = false)
    private String ip;

    @Column(name = "root_domain_crc", nullable = false)
    private Long ipCrc;

    @Column(name = "last_whois_time", nullable = true)
    private java.util.Date lastWhoisTime;

    @Column(name = "insert_time", nullable = true)
    @CreationTimestamp
    private java.util.Date insertTime;

    @Column(name = "update_time", nullable = true)
    @UpdateTimestamp
    private java.util.Date updateTime;

}


