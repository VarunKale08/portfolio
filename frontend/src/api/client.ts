export const API_URL: string = import.meta.env.VITE_API_URL ?? "http://localhost:8080";

export async function getJson<T>(path: string): Promise<T> {
  const response = await fetch(API_URL + path);
  if (!response.ok) {
    throw new Error(`Request failed with status ${response.status}`);
  }
  return (await response.json()) as T;
}

export class ApiError extends Error {
  status: number;
  fieldErrors: Record<string, string>;

  constructor(status: number, message: string, fieldErrors: Record<string, string>) {
    super(message);
    this.status = status;
    this.fieldErrors = fieldErrors;
  }
}

export async function postJson(path: string, body: unknown): Promise<void> {
  const response = await fetch(API_URL + path, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  });
  if (!response.ok) {
    let problem: { detail?: string; errors?: Record<string, string> } = {};
    try {
      problem = await response.json();
    } catch {
      // The error had no JSON body; keep the defaults.
    }
    throw new ApiError(response.status, problem.detail ?? "Request failed", problem.errors ?? {});
  }
}