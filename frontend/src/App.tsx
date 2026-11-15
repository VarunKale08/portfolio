import { Route, Routes } from "react-router";
import Layout from "./components/Layout";
import About from "./pages/About";
import Projects from "./pages/Projects";
import Cv from "./pages/Cv";
import Contact from "./pages/Contact";

export default function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route index element={<About />} />
        <Route path="projects" element={<Projects />} />
        <Route path="cv" element={<Cv />} />
        <Route path="contact" element={<Contact />} />
      </Route>
    </Routes>
  );
}