package fr.dopse.maildump.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Created by fr27a86n on 11/04/2017.
 */

@Entity
@Table(name = "EMAIL")
public class EmailEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "SENDER_NAME")
	private String senderName;

	@Column(name = "SENDER_ADDRESS")
	private String senderAddress;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<RecipientEntity> recipients;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<AttachmentEntity> attachments;

	@Column(name = "SUBJECT")
	private String subject;

	@Lob
	@Column(name = "CONTENT")
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
    private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public List<RecipientEntity> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<RecipientEntity> recipients) {
		this.recipients = recipients;
	}

	public List<AttachmentEntity> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentEntity> attachments) {
		this.attachments = attachments;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
