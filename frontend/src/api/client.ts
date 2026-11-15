export const API_URL: string = import.meta.env.VITE_API_URL ?? "http://localhost:8080";

export async function getJson<T>(path: string): Promise<T> {
  const response = await fetch(API_URL + path);
  if (!response.ok) {
    throw new Error(`Request failed with status ${response.status}`);
  }
  return (await response.json()) as T;
}