type StatusProps = {
  loading: boolean;
  error: string | null;
};

export default function Status({ loading, error }: StatusProps) {
  if (loading) return <p className="small">Loading...</p>;
  if (error) return <p className="small">{error}</p>;
  return null;
}