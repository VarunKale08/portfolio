import { useState } from "react";
import { ApiError, postJson } from "../api/client";

type Form = { name: string; email: string; subject: string; message: string };

const EMPTY: Form = { name: "", email: "", subject: "", message: "" };

export default function Contact() {
  const [form, setForm] = useState<Form>(EMPTY);
  const [fieldErrors, setFieldErrors] = useState<Record<string, string>>({});
  const [note, setNote] = useState("");
  const [sending, setSending] = useState(false);

  function update(field: keyof Form, value: string) {
    setForm({ ...form, [field]: value });
  }

  async function handleSubmit(event: { preventDefault(): void }) {
    event.preventDefault();
    setSending(true);
    setFieldErrors({});
    setNote("");
    try {
      await postJson("/api/contact", form);
      setForm(EMPTY);
      setNote("Message sent. Thank you, I will reply soon.");
    } catch (error) {
      if (error instanceof ApiError && error.status === 400) {
        setFieldErrors(error.fieldErrors);
        setNote("Please check the marked fields.");
      } else if (error instanceof ApiError && error.status === 429) {
        setNote(error.message);
      } else {
        setNote("Could not send the message. Please try again in a minute.");
      }
    } finally {
      setSending(false);
    }
  }

  return (
    <div className="page">
        <div className="crumb">
        <span>varun kale / contact</span>
        </div>
      <h1>Contact</h1>

      <form onSubmit={handleSubmit} noValidate>
        <label htmlFor="name">
          Name
          <input id="name" value={form.name} onChange={(e) => update("name", e.target.value)} autoComplete="name" />
          {fieldErrors.name && <span className="field-error">{fieldErrors.name}</span>}
        </label>
        <label htmlFor="email">
          Email
          <input id="email" type="email" value={form.email} onChange={(e) => update("email", e.target.value)} autoComplete="email" />
          {fieldErrors.email && <span className="field-error">{fieldErrors.email}</span>}
        </label>
        <label htmlFor="subject">
          Subject
          <input id="subject" value={form.subject} onChange={(e) => update("subject", e.target.value)} />
          {fieldErrors.subject && <span className="field-error">{fieldErrors.subject}</span>}
        </label>
        <label htmlFor="message">
          Message
          <textarea id="message" value={form.message} onChange={(e) => update("message", e.target.value)} />
          {fieldErrors.message && <span className="field-error">{fieldErrors.message}</span>}
        </label>
        <button className="send arrow" type="submit" disabled={sending}>
          {sending ? "sending..." : "send message"}
        </button>
        {note && <p className="small">{note}</p>}
      </form>
    </div>
  );
}