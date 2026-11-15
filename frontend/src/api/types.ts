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


export type Experience = {
  role: string;
  company: string;
  location: string;
  startDate: string;
  endDate: string | null;
  highlights: { title: string; detail: string }[];
};

export type Education = {
  degree: string;
  institution: string;
  location: string;
  grade: string;
  honors: string | null;
  endDate: string;
};

export type Publication = {
  title: string;
  publisher: string;
  publishedDate: string;
  url: string | null;
};

export type SkillCategory = {
  category: string;
  skills: string[];
};