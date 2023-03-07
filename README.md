# RIFE2 IDEA Support

[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/java-11%2B-blue)](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
[![Version](https://img.shields.io/jetbrains/plugin/v/20947-RIFE2.svg)](https://plugins.jetbrains.com/plugin/20947-rife2)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/20947-RIFE2.svg)](https://plugins.jetbrains.com/plugin/20947-rife2)
![Build](https://github.com/rife2/rife2-idea/workflows/Build/badge.svg)
[![Tests](https://rife2.com/tests-badge/badge/com.uwyn.rife2/rife2-idea)](https://github.com/rife2/rife2/actions/workflows/gradle.yml)
<!-- Plugin description -->
Support for the RIFE2 web framework: https://rife2.com

* Provides file templates for Element, Router and Site class creation.
* Provides Java live templates for common routing idioms.
* Provides template engine live templates for tag creation and surrounding.
* Supports HTML, JSON, SVG, TXT and XML template language highlighting with
  fallback to original languages.
* Filtered value tags auto-completion to all template types.
* Syntax highlighting color settings configuration panel.
* Auto-tag closing characters addition when typing { or <!.

After installing the RIFE2 plugins from the marketplace, the recognized template
file types will automatically support RIFE2 template tags. Any code outside
those template tags will be handled by the original IDEA language support.

No configuration is necessary, but if desired, the highlighted colors can be
changed for each template tag type and tag name.
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "RIFE2"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/rife2/rife2-idea/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
