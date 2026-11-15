export type SocialLink = {
  platform: string;
  url: string;
};

export type Profile = {
  fullName: string;
  title: string;
  tagline: string;
  about: string;
  location: string;
  links: SocialLink[];
};


export type Project = {
  slug: string;
  title: string;
  summary: string;
  description: string;
  imageUrl: string | null;
  githubUrl: string | null;
  liveUrl: string | null;
  featured: boolean;
  techStack: string[];
};