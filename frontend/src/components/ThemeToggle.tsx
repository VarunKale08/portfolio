import { useState } from "react";

function isDarkNow(): boolean {
  const chosen = document.documentElement.getAttribute("data-theme");
  if (chosen) return chosen === "dark";
  return window.matchMedia("(prefers-color-scheme: dark)").matches;
}

export default function ThemeToggle() {
  const [dark, setDark] = useState(isDarkNow);

  function toggle() {
    const next = dark ? "light" : "dark";
    document.documentElement.setAttribute("data-theme", next);
    try {
      localStorage.setItem("theme", next);
    } catch {
      // Storage can be blocked in private windows; the switch still works for this visit.
    }
    setDark(!dark);
  }

  return (
    <button className="theme" type="button" onClick={toggle}>
      {dark ? "light mode" : "dark mode"}
    </button>
  );
}