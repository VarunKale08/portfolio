import { useEffect, useState } from "react";
import { getJson } from "../api/client";

type ApiState<T> = {
  data: T | null;
  error: string | null;
  loading: boolean;
};

export function useApi<T>(path: string): ApiState<T> {
  const [state, setState] = useState<ApiState<T>>({ data: null, error: null, loading: true });

  useEffect(() => {
    let cancelled = false;

    getJson<T>(path)
      .then((data) => {
        if (!cancelled) setState({ data, error: null, loading: false });
      })
      .catch(() => {
        if (!cancelled) {
          setState({ data: null, error: "Could not load this section. Please try again in a minute.", loading: false });
        }
      });

    // Runs if the visitor leaves the page before the answer arrives.
    return () => {
      cancelled = true;
    };
  }, [path]);

  return state;
}