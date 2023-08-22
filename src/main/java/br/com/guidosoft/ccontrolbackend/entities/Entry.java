package br.com.guidosoft.ccontrolbackend.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cc_entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fixedEntry;
    private int status;
    @ManyToOne
    @JoinColumn(name = "cc_user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "cc_collaborator_id")
    private Collaborator collaborator;
    @ManyToOne
    @JoinColumn(name = "cc_field_id")
    private Field field;
    @ManyToOne
    @JoinColumn(name = "cc_value_id")
    private Value value;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "update_at")
    private Timestamp updatedAt;

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFixedEntry() {
        return fixedEntry;
    }

    public void setFixedEntry(int fixedEntry) {
        this.fixedEntry = fixedEntry;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(id, entry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
