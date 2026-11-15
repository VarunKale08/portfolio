const MONTHS = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

// "2025-06-15" -> "Jun 2025"
export function monthYear(iso: string): string {
  const [year, month] = iso.split("-");
  return `${MONTHS[Number(month) - 1]} ${year}`;
}

// "2026-06-01" -> "2026"
export function yearOf(iso: string): string {
  return iso.slice(0, 4);
}