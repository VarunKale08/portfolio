import { useEffect, useState } from "react";

type StatusProps = {
  loading: boolean;
  error: string | null;
};

export default function Status({ loading, error }: StatusProps) {
  const [slow, setSlow] = useState(false);

  useEffect(() => {
    if (!loading) return;
    const timer = setTimeout(() => setSlow(true), 4000);
    return () => clearTimeout(timer);
  }, [loading]);

  if (loading) {
    return <p className="small">{slow ? "Waking up the server. This can take up to a minute..." : "Loading..."}</p>;
  }
  if (error) return <p className="small">{error}</p>;
  return null;
}